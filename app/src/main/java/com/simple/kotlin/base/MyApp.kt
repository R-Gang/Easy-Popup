package com.simple.kotlin.base

import com.gang.library.BaseApp
import com.gang.library.common.user.Config
import com.gang.recycler.kotlin.manager.LayoutManager
import com.gang.tools.kotlin.ToolsConfig
import com.gang.tools.kotlin.utils.initToolsUtils

/**
 * @ProjectName: Easy-Popup
 * @Package: com.simple.kotlin
 * @ClassName: MyApp
 * @Description: java类作用描述
 * @Author: haoruigang
 * @CreateDate: 2022/3/7 16:30
 */
class MyApp : BaseApp() {
    override fun onCreate() {

        Config.statusBarEnabled = false

        super.onCreate()

        initToolsUtils(this)
        LayoutManager.instance?.init(this)
    }
}