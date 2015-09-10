module.exports = {
  set: function(volumeValue){
    //correct the volume value if it's out of the bounds (0;100)
    if (volumeValue < 0){
      volumeValue = 0
      console.log("Volume value "+volumeValue+" lower than 0 => corrected to 0")
    }
    else if (volumeValue > 100){
      volumeValue = 100
      console.log("Volume value "+volumeValue+" bigger than 100 => corrected to 100")
    }

    console.log("Setting system volume to value "+volumeValue)

    //call the native method set of native class systemVolume
    cordova.exec(
      function(){
        console.log("Volume set to value : "+volumeValue)
      },
      function(error){
      console.log(error)
      },
      "systemVolume",
      "set",
      [volumeValue]);
  }
}
