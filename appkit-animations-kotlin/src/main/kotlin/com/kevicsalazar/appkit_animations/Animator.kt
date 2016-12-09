package com.kevicsalazar.appkit_animations

import android.animation.*
import android.view.View

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

enum class Anim(val propertyName: String) {
    Alpha("alpha"),
    Rotation("rotation"),
    RotationX("rotationX"),
    RotationY("rotationY"),
    ScaleX("scaleX"),
    ScaleY("scaleY"),
    TranslationX("translationX"),
    TranslationY("translationY"),
    TranslationZ("translationZ"),
    X("x"),
    Y("y"),
    Z("z"),
}

// ObjectAnimator

fun View.anim(anim: Anim, vararg values: Int, init: (ObjectAnimator.() -> Unit)? = null) = ObjectAnimator.ofInt(this, anim.propertyName, *values).apply {
    init?.let { init() }
}!!

fun View.anim(anim: Anim, vararg values: Float, init: (ObjectAnimator.() -> Unit)? = null) = ObjectAnimator.ofFloat(this, anim.propertyName, *values).apply {
    init?.let { init() }
}!!

// AnimatorSet

fun playTogether(vararg animators: ObjectAnimator, init: (AnimatorSet.() -> Unit)? = null): AnimatorSet {
    val animatorSet = AnimatorSet()
    animatorSet.playTogether(*animators)
    init?.let { init(animatorSet) }
    return animatorSet
}

fun playSequentially(vararg animators: ObjectAnimator, init: (AnimatorSet.() -> Unit)? = null): AnimatorSet {
    val animatorSet = AnimatorSet()
    animatorSet.playSequentially(*animators)
    init?.let { init(animatorSet) }
    return animatorSet
}

// Animations

fun View.pivotAnimator(init: (ObjectAnimator.() -> Unit)? = null) = anim(Anim.TranslationY, 0f, -0.3f * height, 0f, -0.15f * height, 0f, 0f, 0f) {
    duration = 1200
    repeatCount = ValueAnimator.INFINITE
    repeatMode = ValueAnimator.RESTART
    init?.let { init(this) }
}

fun View.pulseAnimator(init: (AnimatorSet.() -> Unit)? = null) = playTogether(
        anim(Anim.ScaleX, 0.9f, 0.9f, 1.1f, 1f) {
            duration = 800
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
        },
        anim(Anim.ScaleY, 0.9f, 0.9f, 1.1f, 1f) {
            duration = 800
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
        }, init = init)