# cordova-plugin-systemvolume

## Description
A Cordova plugin that lets you set device volume programmatically. Only for iOS for the moment.

## Usage
The method set of the object systemVolume that is provided by this plugin takes as argument a float between 0 and 100 that represents the volume level, 0 being the lowest volume level and 100 being the highest volume level.
If the argument is lower than 0, the value is set to 0. If the argument is bigger than 100, the value is set to 100.

example:

    volumeValue.set(50) //sets the volume to middle value

The plugin is based on the tip found on :
http://stackoverflow.com/questions/19218729/ios-7-mpmusicplayercontroller-volume-deprecated-how-to-change-device-volume-no/24993026#24993026

## Version History

### 0.1.0

* Initial release, works with cordova 5.3.1 and iOS 8.4.1

## License
This code is released under the MIT license.
