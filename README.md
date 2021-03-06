# Android Material Intro Screen

This is a fork of [TangoAgency/material-intro-screen](https://github.com/TangoAgency/material-intro-screen) with the following changes:
- Support for androidx
- Updated libraries and target SDK
- padding fix for long descriptions
- renamed package from agency.tango. to com.avrapps
- published to maven central

Material intro screen is inspired by [Material Intro] and developed with love from scratch. I decided to rewrite completely almost all features in order to make Android intro screen easy to use for everyone and extensible as possible.

## OUR PROMISE

Original repo is not maintained and was no activity or pull requests. We make sure we keep the repo upto date, fix all issues reported and look into feature requests as well. At least we will allow fellow developers to contribute to the project or find an alternate owner in case we can't maintain it.

## Features
  - [Easily add new slides][Intro Activity]
  - [Custom slides][Custom Slide]
  - [Parallax slides][Parallax Slide]
  - Easy extensible api
  - Android TV support!
  - Material design at it's best!!!

| [Simple slide][SimpleSlide] | [Custom slide][Custom Slide] | [Permission slide][PermissionSlide] | [Finish slide][FinishSlide]
|:-:|:-:|:-:|:-:|
| ![Simple slide] | ![Customslide] | ![Permission slide] | ![Finish slide] |

## Usage
### Step 1:
#### Add gradle dependecy
```
dependencies {
  implementation 'com.avrapps:material-intro-screen:0.0.1'
}
```
### Step 2:
#### First, your [intro activity][Intro Activity] class needs to extend MaterialIntroActivity:
```java
public class IntroActivity extends MaterialIntroActivity
```
### Step 3:
#### Add activity to [manifest][Manifest] with defined theme:
```xml
        <activity
            android:name=".IntroActivity"
            android:theme="@style/Theme.Intro" />
```
### Step 4: 
#### [Add slides:][Intro Activity]
```java
 @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.colorAccent)
                .possiblePermissions(new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.READ_SMS})
                .neededPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
                .image(com.avrapps.materialintroscreen.R.drawable.ic_next)
                .title("title 3")
                .description("Description 3")
                .build(),
                new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage("We provide solutions to make you love your work");
                    }
                }, "Work with love"));
}
```
#### Explanation of SlideFragment usage:
  - ```possiblePermissions``` &#8702; permissions which are not necessary to be granted
  - ```neededPersmissions``` &#8702; permission which are needed to be granted to move further from that slide
  - ```MessageButtonBehaviour``` &#8702; create a new instance only if you want to have a custom action or text on a message button

### Step 5: 
#### Customize Intro Activity:
  - ```setSkipButtonVisible()``` &#8702; show skip button instead of back button on the left bottom of screen
  - ```hideBackButton()``` &#8702; hides any button on the left bottom of screen
  - ```enableLastSlideAlphaExitTransition()``` &#8702; set if the last slide should disapear with alpha hiding effect

#### Customizing view animations: 

You can set enter, default and exit translation for every view in intro activity. To achive this you need to get translation wrapper for chosen view (for example: ```getNextButtonTranslationWrapper()```) and set there new class which will implement ```IViewTranslation```
```java
getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });
```
#### Available [translation wrappers][TranslationWrapper]:
- ```getNextButtonTranslationWrapper()```
- ```getBackButtonTranslationWrapper()```
- ```getPageIndicatorTranslationWrapper()```
- ```getViewPagerTranslationWrapper()``` 
- ```getSkipButtonTranslationWrapper()``` 

## Custom slides
#### Of course you are able to implement completely custom slides. You only need to extend SlideFragment and override following functions:
 - ```backgroundColor()```
 - ```buttonsColor()```
 - ```canMoveFurther()``` (only if you want to stop user from being able to move further before he will do some action)
 - ```cantMoveFurtherErrorMessage()``` (as above)
 
#### If you want to use parallax in a fragment please use one of the below views:
  - [```ParallaxFrameLayout```][ParallaxFrame]
  - [```ParallaxLinearLayout```][ParallaxLinear]
  - [```ParallaxRelativeLayout```][ParallaxRelative]

#### And set there the [app:layout_parallaxFactor][ParallaxFactor] attribute:
```xml
<com.avrapps.materialintroscreen.parallax.ParallaxLinearLayout
xmlns:android="http://schemas.android.com/apk/res/android">

    <ImageView
        android:id="@+id/image_slide"
        app:layout_parallaxFactor="0.6"/>
```

## Getting Help

To report a specific problem or feature request, [open a new issue on Github](https://github.com/avrapps/material-intro-screen/issues/new).

## Company

You can contact us via avrapps.store@gmail.com.
Thanks in advance.
