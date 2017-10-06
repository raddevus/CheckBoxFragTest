# CheckBoxFragTest
Android project displaying issues of TabView, ViewPager, Checkboxes and strange Nougat view-state<br/>
I posted a question on StackOverflow about an odd checkbox state that can only be seen on Nougat versions.<br/>
Please take a look at that SO issue at: https://stackoverflow.com/questions/46516506/android-nougat-why-do-checkboxes-on-fragment-have-incomplete-state-when-selecte<br/>
<br/>
If you run the CheckBoxFragTest on Nougat you will see that you can click the button on the first tab and 
it will properly set the checkbox on the 3rd tab, but the second tab will go to the odd semi-selected state.  <br/>
Of course, if you check the value of the checkbox it will be checked, but the related view isn't completely updated.
