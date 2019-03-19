# SkyBlu
SkyBlu was a simple UI testing application I created to test out Adobe XD and Android Studio designing.  
The asset files are inside the "assets" folder as an Adobe XD file.  

### How to export/import a vector from Adobe XD to Android Studio
- From Adobe XD, export the selected assets as an "SVG"
- Then, from Android Studio, on the "drawable" folder right click it and click "New" then click "New Vector Asset" and import it

### How to export/import a bitmap image from Adobe XD to Android Studio
- From Adobe XD, export the selected assets as a "png" or "jpg" and click the "Android" option
- Then, go to your "res" folder directory on your Android Studio project and export it there

### Exporting Conflicts I encountered
- Using opacity on a vector in Adobe XD, exporting it as an SVG, then loading on Android Studio does not properly work
  - To fix this, use the "fill" and "border" colors with an alpha in Adobe XD or export as a png/jpg instead
  
### Helpful Tips for Android Studio Designing
- Android Studio's "infer constraints" button automatically adds constraints to your design
  - Sometimes it may mess up, so just align positions here and there and maybe add/remove some constraints to get it working
- To test the design for you specific device, select the "Phone" tab on the top of your layout, then "Add Device Definition,
  then "Create Virtual Device," then "New Hardware Profile," and lastly add your phone's specifications
  - Once you add your phone, go back to the "Phone" tab and click "Generic Phones and Tablets" and choose your phone
