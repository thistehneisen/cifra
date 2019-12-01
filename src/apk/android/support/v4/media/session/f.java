package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* compiled from: MediaControllerCompatApi21 */
class f {

    /* compiled from: MediaControllerCompatApi21 */
    public interface a {
        void a(int i2, int i3, int i4, int i5, int i6);

        void a(Bundle bundle);

        void a(CharSequence charSequence);

        void a(Object obj);

        void a(String str, Bundle bundle);

        void a(List<?> list);

        void b();

        void b(Object obj);
    }

    /* compiled from: MediaControllerCompatApi21 */
    static class b<T extends a> extends Callback {

        /* renamed from: a reason: collision with root package name */
        protected final T f359a;

        public b(T t) {
            this.f359a = t;
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
            this.f359a.a(playbackInfo.getPlaybackType(), c.b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f359a.a(bundle);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f359a.a((Object) mediaMetadata);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f359a.b(playbackState);
        }

        public void onQueueChanged(List<QueueItem> list) {
            this.f359a.a(list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f359a.a(charSequence);
        }

        public void onSessionDestroyed() {
            this.f359a.b();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f359a.a(str, bundle);
        }
    }

    /* compiled from: MediaControllerCompatApi21 */
    public static class c {
        public static AudioAttributes a(Object obj) {
            return ((PlaybackInfo) obj).getAudioAttributes();
        }

        public static int b(Object obj) {
            return a(a(obj));
        }

        private static int a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 1:
                case 11:
                case 12:
                case 14:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
                default:
                    return 3;
            }
        }
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }
}
