#import <Cordova/CDV.h>

@interface SystemVolume : CDVPlugin
{
  UISlider* volumeViewSlider;
}
- (void)set:(CDVInvokedUrlCommand*)command;

@end
