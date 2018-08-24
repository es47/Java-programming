23.11
BouncingBall.java:
設定ball的參數，以及參數的get()和set() function，還有移動方向及位置。

BallPanel.java:
有一個BouncingBall的arraylist，當收到mouse click的指令，產生出一個新的ball，然後畫出arraylist內的ball。

TestBouncingBall.java:
呼叫BallPanel內的run()，讓球可以開始移動。

makefile:
利用make指令，compile上述檔案，即可執行。