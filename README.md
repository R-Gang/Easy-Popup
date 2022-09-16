# Easy-Popup

引入方式：

[![](https://jitpack.io/v/R-Gang/Easy-Popup.svg)](https://jitpack.io/#R-Gang/Easy-Popup)

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

    dependencies {
         implementation 'com.github.R-Gang:Easy-Popup:latest.integration'
    }


PopupWindow

对 PopupWindow 的封装，使得在项目中使用起来更加简单、方便、快捷

![easy_popup.gif](https://github.com/R-Gang/Easy-Popup/blob/master/images/easy_popup.gif)

## 使用

### 初始化 View

可以 viewBinding=true 获取 View 对象。

```
    private var releaseBinding: PopupReleaseDownBinding? = null
    
    releaseBinding = PopupReleaseDownBinding.inflate(layoutInflater)
```

### 创建 EasyPopup 对象

可以调用 setXxx() 方法进行属性设置，最后调用 createPopup() 方法实现对PopupWindow的初始化。

```
    /**
     * 发布弹框
     */
    private val mReleasePop by lazy {
        EasyPopup.create().setContentView(releaseBinding?.root)
            ?.setAnimationStyle(R.style.RightTopPopAnim)
            ?.setOnViewListener(object : EasyPopup.OnViewListener {
                override fun initViews(view: View?, popup: EasyPopup?) {
                    releaseBinding?.apply {
                        vArrow.background =
                            TriangleDrawable(ARROWDIRECTION.TOP,
                                Color.parseColor("#FFFFFF"))
                        rlArticle.setOnClickListener { ToastUtils.showShort("文章"); }
                        rlVideo.setOnClickListener { ToastUtils.showShort("视频"); }
                    }
                }
            })
            ?.setOnDismissListener { // todo 监听popup消失 }
            ?.setFocusAndOutsideEnable(true)
            //.setBackgroundDimEnable(true)
            //.setDimValue(0.5f)
            //.setDimColor(Color.RED)
            //.setDimView(mTitleBar)
            ?.apply()
    }
```

### 显示

相对于 view 位置显示

```
   /**
    * 相对anchor view显示，适用 宽高不为match_parent
    *
    * @param anchor
    * @param yGravity  垂直方向的对齐方式
    * @param xGravity  水平方向的对齐方式
    * @param x            水平方向的偏移
    * @param y            垂直方向的偏移
    */
    releasePop?.showAtAnchorView(view, YGravity.CENTER, XGravity.LEFT, 0, 0);
```

除了 showAtAnchorView() 方法，内部还保留了 showAsDropDown()、showAtLocation() 方法。

注意：如果使用 YGravity 和 XGravity 时，请确保使用之后 PopupWindow 没有超出屏幕边界，如果超出屏幕边界，YGravity 和 XGravity
可能无效，从而达不到你想要的效果。#4

## Reference

[EasyPopup「暂停维护」](https://github.com/zyyoona7/EasyPopup)
