package io.intercom.android.sdk.utilities;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Phrase {
    private static final int EOF = 0;
    private char curChar;
    private int curCharIndex;
    private CharSequence formatted;
    private Token head;
    private final Set<String> keys = new HashSet();
    private final Map<String, CharSequence> keysToValues = new HashMap();
    private final CharSequence pattern;

    private static class KeyToken extends Token {
        private final String key;
        private CharSequence value;

        KeyToken(Token token, String str) {
            super(token);
            this.key = str;
        }

        /* access modifiers changed from: 0000 */
        public void expand(SpannableStringBuilder spannableStringBuilder, Map<String, CharSequence> map) {
            this.value = (CharSequence) map.get(this.key);
            int formattedStart = getFormattedStart();
            spannableStringBuilder.replace(formattedStart, this.key.length() + formattedStart + 2, this.value);
        }

        /* access modifiers changed from: 0000 */
        public int getFormattedLength() {
            return this.value.length();
        }
    }

    private static class LeftCurlyBracketToken extends Token {
        LeftCurlyBracketToken(Token token) {
            super(token);
        }

        /* access modifiers changed from: 0000 */
        public void expand(SpannableStringBuilder spannableStringBuilder, Map<String, CharSequence> map) {
            int formattedStart = getFormattedStart();
            spannableStringBuilder.replace(formattedStart, formattedStart + 2, "{");
        }

        /* access modifiers changed from: 0000 */
        public int getFormattedLength() {
            return 1;
        }
    }

    private static class TextToken extends Token {
        private final int textLength;

        TextToken(Token token, int i2) {
            super(token);
            this.textLength = i2;
        }

        /* access modifiers changed from: 0000 */
        public void expand(SpannableStringBuilder spannableStringBuilder, Map<String, CharSequence> map) {
        }

        /* access modifiers changed from: 0000 */
        public int getFormattedLength() {
            return this.textLength;
        }
    }

    private static abstract class Token {
        Token next;
        private final Token prev;

        protected Token(Token token) {
            this.prev = token;
            if (token != null) {
                token.next = this;
            }
        }

        /* access modifiers changed from: 0000 */
        public abstract void expand(SpannableStringBuilder spannableStringBuilder, Map<String, CharSequence> map);

        /* access modifiers changed from: 0000 */
        public abstract int getFormattedLength();

        /* access modifiers changed from: 0000 */
        public final int getFormattedStart() {
            Token token = this.prev;
            if (token == null) {
                return 0;
            }
            return token.getFormattedStart() + this.prev.getFormattedLength();
        }
    }

    private Phrase(CharSequence charSequence) {
        char c2 = 0;
        if (charSequence.length() > 0) {
            c2 = charSequence.charAt(0);
        }
        this.curChar = c2;
        this.pattern = charSequence;
        Token token = null;
        while (true) {
            token = token(token);
            if (token == null) {
                return;
            }
            if (this.head == null) {
                this.head = token;
            }
        }
    }

    private void consume() {
        this.curCharIndex++;
        this.curChar = this.curCharIndex == this.pattern.length() ? 0 : this.pattern.charAt(this.curCharIndex);
    }

    public static Phrase from(Fragment fragment, int i2) {
        return from(fragment.getResources(), i2);
    }

    private KeyToken key(Token token) {
        char c2;
        StringBuilder sb = new StringBuilder();
        consume();
        while (true) {
            char c3 = this.curChar;
            if (c3 < 'a' || c3 > 'z') {
                char c4 = this.curChar;
                if (c4 < 'A' || c4 > 'Z') {
                    c2 = this.curChar;
                    if (c2 != '_') {
                        break;
                    }
                }
            }
            sb.append(this.curChar);
            consume();
        }
        String str = "'";
        if (c2 == '}') {
            consume();
            if (sb.length() != 0) {
                String sb2 = sb.toString();
                this.keys.add(sb2);
                return new KeyToken(token, sb2);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Empty key: {} in '");
            sb3.append(this.pattern);
            sb3.append(str);
            throw new IllegalArgumentException(sb3.toString());
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Missing closing brace: } in '");
        sb4.append(this.pattern);
        sb4.append(str);
        throw new IllegalArgumentException(sb4.toString());
    }

    private LeftCurlyBracketToken leftCurlyBracket(Token token) {
        consume();
        consume();
        return new LeftCurlyBracketToken(token);
    }

    private char lookahead() {
        if (this.curCharIndex < this.pattern.length() - 1) {
            return this.pattern.charAt(this.curCharIndex + 1);
        }
        return 0;
    }

    private TextToken text(Token token) {
        int i2 = this.curCharIndex;
        while (true) {
            char c2 = this.curChar;
            if (c2 != '{' && c2 != 0) {
                consume();
            }
        }
        return new TextToken(token, this.curCharIndex - i2);
    }

    private Token token(Token token) {
        char c2 = this.curChar;
        if (c2 == 0) {
            return null;
        }
        if (c2 != '{') {
            return text(token);
        }
        char lookahead = lookahead();
        if (lookahead == '{') {
            return leftCurlyBracket(token);
        }
        if (lookahead >= 'a' && lookahead <= 'z') {
            return key(token);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected character '");
        sb.append(lookahead);
        sb.append("'; expected key in '");
        sb.append(this.pattern);
        sb.append("'");
        throw new IllegalArgumentException(sb.toString());
    }

    public CharSequence format() {
        if (this.formatted == null) {
            if (this.keysToValues.keySet().containsAll(this.keys)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.pattern);
                for (Token token = this.head; token != null; token = token.next) {
                    token.expand(spannableStringBuilder, this.keysToValues);
                }
                this.formatted = spannableStringBuilder;
            } else {
                HashSet hashSet = new HashSet(this.keys);
                hashSet.removeAll(this.keysToValues.keySet());
                StringBuilder sb = new StringBuilder();
                sb.append("Missing keys: ");
                sb.append(hashSet);
                sb.append(" in '");
                sb.append(this.pattern);
                sb.append("'");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return this.formatted;
    }

    public void into(TextView textView) {
        if (textView != null) {
            textView.setText(format());
            return;
        }
        throw new IllegalArgumentException("TextView must not be null.");
    }

    public Phrase put(String str, CharSequence charSequence) {
        String str2 = "'";
        if (!this.keys.contains(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Key '");
            sb.append(str);
            sb.append("' not found in '");
            sb.append(this.pattern);
            sb.append(str2);
            throw new IllegalArgumentException(sb.toString());
        } else if (charSequence != null) {
            this.keysToValues.put(str, charSequence);
            this.formatted = null;
            return this;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Null value for '");
            sb2.append(str);
            sb2.append("' in '");
            sb2.append(this.pattern);
            sb2.append(str2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public Phrase putOptional(String str, CharSequence charSequence) {
        return this.keys.contains(str) ? put(str, charSequence) : this;
    }

    public String toString() {
        return this.pattern.toString();
    }

    public static Phrase from(View view, int i2) {
        return from(view.getResources(), i2);
    }

    public Phrase putOptional(String str, int i2) {
        return this.keys.contains(str) ? put(str, i2) : this;
    }

    public static Phrase from(Context context, int i2) {
        return from(context.getResources(), i2);
    }

    public static Phrase from(Resources resources, int i2) {
        return from(resources.getText(i2));
    }

    public static Phrase from(CharSequence charSequence) {
        return new Phrase(charSequence);
    }

    public Phrase put(String str, int i2) {
        return put(str, (CharSequence) Integer.toString(i2));
    }
}
