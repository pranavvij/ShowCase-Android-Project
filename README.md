ShowCase View is currently uses PopUpwindow inorder to highlight icon,text or any View for which u want to ShowCase.You can add multple TextHint for a purticular showcase .TextHint can be present at any position depending on the position you choose for TextHint.
This Project contains showcaselibrary2 as the library which needs to be imported .This is an example of how to implement Showcase View in different scenario.


*  ImageView Icon ShowCase
*  Toolbar Icon ShowCase
*  Over Another Activity
*  More than one TextHint
*  Position AnyWhere TextHint


 ```WooplrShowCaseView wooplrShowCaseView=new       WooplrShowCaseView(imageView.getWidth(),imageView.getHeight(),ImageViewIconShowcase.this,getApplicationContext(),getWindow(),poi nt.right,point.bottom);
 wooplrShowCaseView.setText("Hello World",WooplrShowCaseView.TOPRIGHT,getSupportFragmentManager());```
 
