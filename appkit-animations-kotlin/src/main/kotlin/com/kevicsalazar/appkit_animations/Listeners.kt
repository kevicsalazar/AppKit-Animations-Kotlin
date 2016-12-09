package com.kevicsalazar.appkit_animations

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

// Listeners

fun AnimatorSet.onAnimatorEnd(onAnimationEnd: () -> Unit) {
    addListener(object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator?) {
            super.onAnimationEnd(animation)
            onAnimationEnd()
        }
    })
}