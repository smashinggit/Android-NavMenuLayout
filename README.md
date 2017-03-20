# Android-NavMenu-master

### 一个底部导航栏, 实现了显示未读消息数, 显示红点等效果的封装。

# 添加依赖

#### 1. 在项目根目录的 build.gradle 中添加

    allprojects {
       repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }
  
#### 2. 在项目的 build.gradle 中添加

    compile 'com.github.smashinggit:Android-NavMenu-master:v1.0.2'
    
# 如何使用


## 1. 普通用法

#### 第一步, 在xml文件中添加控件

       在xml中的跟布局添加  xmxmlns:app="http://schemas.android.com/apk/res-auto"
       
        <com.git.navmenu.NavMenuLayout
        android:id="@+id/nav_layout"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_alignParentBottom="true"
        app:menuCount="3" />


注：

    
     app:menuCount="3" 属性是必须要添加的，代表底部菜单的数量，此数值必须要与 Activity 中设置的图片资源，文字资源的数量一致，
     否则无法正常显示
      
       
       
       
#### 第二步, 在Activity中设置数据

      private int[] iconRes = {R.mipmap.ic_home_normal, R.mipmap.ic_managemoney_normal, R.mipmap.ic_me_normal};
      private int[] iconResSelected = {R.mipmap.ic_home_selected, R.mipmap.ic_managemoney_select, R.mipmap.ic_me_select};
      private String[] textRes = {"首页", "理财", "个人中心"};
      
      
        mNavMenuLayout.setIconRes(iconRes)//设置未选中图标
                .setIconResSelected(iconResSelected)//设置选中图标
                .setTextRes(textRes)//设置文字
                .setSelected(0);//设置选中的位置

注：

     setSelected(int position)方法一定要放在最后调用，因为在该方法中实现了刷新页面的功能，其他的几个方法都只是进行了赋值操作，
     并没有刷新页面;
     
#### 效果图


![](https://github.com/smashinggit/Android-NavMenuLayout-Master/blob/master/Screenshots/pic1.png)



## 2. 带消息提示的用法

#### 显示消息或红点提示

       mNavMenuLayout.setIconRes(iconRes)//设置未选中图标
                     .setIconResSelected(iconResSelected)//设置选中图标
                     .setTextRes(textRes)//设置文字
                     .setMsg(0, "99+")//设置显示消息
                     .setMsg(1, "NEW")//设置显示消息
                     .showRedPoint(2)//设置显示红点
                     .setSelected(0);//设置选中的位置
                     
  注：
  
      setMsg(int position,String msg) 方法,第一个参数代表底部菜单的位置，第二个参数代表显示的内容
      showRedPoint(int position)方法，参数代表底部菜单的位置
       
####  取消消息或红点提示

    mNavMenuLayout .hideMsg(0)//隐藏消息
                   .hideMsg(1)//隐藏消息
                   .hideRedPoint(2)//隐藏红点
                      
 注：
 
     mNavMenuLayout .hideMsg(0)//隐藏消息
                    .hideMsg(1)//隐藏消息
                    .hideRedPoint(2)//隐藏红点
#### 效果图

![](https://github.com/smashinggit/Android-NavMenuLayout-Master/blob/master/Screenshots/pic2.png)

## 3. 点击事件

    mNavMenuLayout .hideMsg(0)//隐藏消息
                   .hideMsg(1)//隐藏消息
                   .hideRedPoint(2)//隐藏红点
                      
 注：
 
     mNavMenuLayout .hideMsg(0)//隐藏消息
                    .hideMsg(1)//隐藏消息
                    .hideRedPoint(2)//隐藏红点
#### 效果图

![](https://github.com/smashinggit/Android-NavMenuLayout-Master/blob/master/Screenshots/pic3.png)
![](https://github.com/smashinggit/Android-NavMenuLayout-Master/blob/master/Screenshots/pic4.png)


## 4. 更多个性化定制

    mNavMenuLayout.setIconRes(iconRes)//设置未选中图标
                  .setIconResSelected(iconResSelected)//设置选中图标
                  .setTextRes(textRes)//设置文字
                  .setIconSize(60, 60)//设置图标大小
                  .setIconSize(0, 70,70)
                  .setTextSize(20)//设置文字大小
                  .setTextSize(0, 20)
                  .setTextColor(Color.GRAY)//未选中状态下文字颜色
                  .setTextColorSelected(Color.RED)//选中状态下文字颜色
                  .setBackColor(Color.WHITE)//设置背景色
                  .setBackColor(2,Color.RED)
                  .setMarginTop(PixelUtil.dpToPx(MainActivity.this, 5))//文字和图标直接的距离，默认为5dp
                  .setMarginTop(1, PixelUtil.dpToPx(MainActivity.this, 10))
                  .setSelected(0);//设置选中的位置
                
注：

    以设置图标大小为例，有两个重载方法，
    setIconSize(60, 60) 表示将图标宽高设为 60 * 60，此效果针对于底部所有的item，即底部所有图标大小都会是 60 * 60
    .setIconSize(0, 70,70) 第一个参数代表位置，表示针对将底部哪一个item的图标进行设置
    
## 报错处理

    假如在使用过程中出现了无法显示或者是显示效果不正确等问题，请查看Log,里面会有报错提示。
    
     例如：
     
     如果没有在xml中声明  app:menuCount="" 属性 或者是 属性的值 小于1 ,就会在LogCat中看到这样的提示：
     
     03-18 22:37:58.405 2518-2518/? E/NavMenuLayout: the menuCount mast greater than 0
     03-18 22:37:58.405 2518-2518/? E/NavMenuLayout: the iconRes length is not equals count
     03-18 22:37:58.405 2518-2518/? E/NavMenuLayout: the iconResSelected length is not equals count
     03-18 22:37:58.405 2518-2518/? E/NavMenuLayout: the textRes length is not equals count
     
## 联系方式
    
     如果在使用过程中有什么问题或者是意见，请联系我。谢谢大家！
     
     qq: 2670469507
     邮箱：smashing_chen@163.com
   
