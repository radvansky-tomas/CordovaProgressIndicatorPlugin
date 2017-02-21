Cordova Progress Indicator Plugin
======

Cordova Plugin allowing to show native progress indicators of different types.

======

iOS Plugin is based on SVProgressHUD library
https://github.com/SVProgressHUD/SVProgressHUD

Library is installed as CocoaPods dependency using cordova-plugin-cocoapod-support
https://github.com/blakgeek/cordova-plugin-cocoapods-support

Plugin is exposing following SVProgressHUD methods:

+ (void)show;
+ (void)showWithStatus:(NSString*)string;
+ (void)dismiss;
+ (bool)isShown;

Methods are exposed inside swift file, which was possible due to:
https://www.npmjs.com/package/cordova-plugin-add-swift-support

======

Android Plugin is based on ACProgressLite library
https://github.com/Cloudist/ACProgressLite

Library is installed as Gradle dependency using cordova native framework declaration

Plugins is exposing following ACProgressLite method:
+ (void)show;
+ (void)dismiss;
+ (bool)isShown;
