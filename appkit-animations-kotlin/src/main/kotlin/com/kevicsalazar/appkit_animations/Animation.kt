package com.kevicsalazar.appkit_animations

import android.view.animation.Animation

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

fun Animation.onAnimationEnd(onAnimationEnd: () -> Unit) {
    setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(p0: Animation?) {}
        override fun onAnimationEnd(p0: Animation?) {onAnimationEnd()}
        override fun onAnimationStart(p0: Animation?) {}
    })
}