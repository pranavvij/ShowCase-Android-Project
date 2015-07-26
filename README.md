ShowCase View is currently uses PopUpwindow inorder to highlight icon,text or any View for which u want to ShowCase.You can add multple TextHint for a purticular showcase .TextHint can be present at any position depending on the position you choose for TextHint.
This Project contains showcaselibrary2 as the library which needs to be imported .This is an example of how to implement Showcase View in different scenario.

1) ImageView Icon ShowCase
2) Toolbar Icon ShowCase
3) Over Another Activity
4) More than one TextHint
5) Position AnyWhere TextHint


###### WooplrShowCaseView wooplrShowCaseView=new WooplrShowCaseView(imageView.getWidth(),imageView.getHeight(),ImageViewIconShowcase.this,getApplicationContext(),getWindow(),point.right,point.bottom);
###### wooplrShowCaseView.setText("Hello World",WooplrShowCaseView.TOPRIGHT,getSupportFragmentManager());
###### removeOnGlobalLayoutListener(imageView,this);
