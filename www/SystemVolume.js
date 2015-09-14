module.exports = {
  set: function(volumeValue){
    //correct the volume value if it's out of the bounds (0;100)
    volumeValue = Math.round(volumeValue);
    volumeValue = Math.max(volumeValue,0);
    volumeValue = Math.min(volumeValue,100);

    console.log("Setting system volume to value "+volumeValue)

    //call the native method set of native class systemVolume
    cordova.exec(
      function(){
        console.log("Volume set to value : "+volumeValue)
      },
      function(error){
      console.log(error)
      },
      "SystemVolume",
      "set",
      [volumeValue]);
  }
}
