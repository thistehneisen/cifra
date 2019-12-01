package com.bumptech.glide.load.engine;

/* renamed from: com.bumptech.glide.load.engine.e reason: case insensitive filesystem */
/* compiled from: CallbackException */
final class C0291e extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    C0291e(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
