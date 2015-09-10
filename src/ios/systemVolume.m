#import "systemVolume.h"
#import <Cordova/CDV.h>
#import <MediaPlayer/MediaPlayer.h>
#import <Foundation/Foundation.h>

@implementation systemVolume

- (void)pluginInitialize
{
  MPVolumeView* volumeView = [[MPVolumeView alloc] init];

  //find the volumeSlider
  volumeViewSlider = nil;
  for (UIView *view in [volumeView subviews]){
    if ([view.class.description isEqualToString:@"MPVolumeSlider"]){
        volumeViewSlider = (UISlider*)view;
        break;
    }
  }
}

- (void)set:(CDVInvokedUrlCommand*)command
{
  //get the new volume value (between 0 and 100)
  float newVolumeValue_0_100 = [[command.arguments objectAtIndex:0] floatValue];
  //divide it by 100 to have the right new sysem volume value between 0 and 1
  float newVolumeValue = 0.01 * newVolumeValue_0_100;


  //set the new volume value
  [volumeViewSlider setValue:newVolumeValue animated:YES];
  [volumeViewSlider sendActionsForControlEvents:UIControlEventTouchUpInside];
}
@end
