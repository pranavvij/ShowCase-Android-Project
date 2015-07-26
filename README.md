ShowCase View is currently uses PopUpwindow inorder to highlight icon,text or any View for which u want to ShowCase.You can add multple TextHint for a purticular showcase .TextHint can be present at any position depending on the position you choose for TextHint.
This Project contains showcaselibrary2 as the library which needs to be imported .This is an example of how to implement Showcase View in different scenario.


*  ImageView Icon ShowCase
*  Toolbar Icon ShowCase
*  Over Another Activity
*  More than one TextHint
*  Position AnyWhere TextHint




 ``` 
Rect point=WooplrShowCaseView.locateView(View);
WooplrShowCaseView showcase=new WooplrShowCaseView(View.getWidth(),View.getHeight(),ViewIconShowcase.this,getApplicationContext(),getWindow(),point.right,point.bottom);
wooplrShowCaseView.setText("Hello World",WooplrShowCaseView.TOPRIGHT,getSupportFragmentManager());
```
 
Setting Position of TextHint is simple just set WooplrShowCaseView.direction
Where direction can be:-

* TOPLEFT
* TOP
* TOPRIGHT
* RIGHT
* BOTTOMRIGHT
* BOTTOM
* BOTTOMLEFT
* LEFT


