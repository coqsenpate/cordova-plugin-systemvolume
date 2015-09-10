#import <Cordova/CDV.h>

@interface systemVolume : CDVPlugin
{
  UISlider* volumeViewSlider;
}
- (void)set:(CDVInvokedUrlCommand*)command;

@end
