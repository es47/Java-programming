12.17
根據8.1, 9.1, 10.2的要求，寫出MyShape.java, MyLine.java, MyBoundedShape.java, MyRectangle.java, MyOval.java五個檔案。
MyShape.java有x1, y1, x2, y2及color五個變數，以及每個變數的set和get function，有兩個constructor，還有一個abstract function - draw。
MyLine.java extends MyShape，有完整的draw function。
MyBoundedShape.java extends MyShape，還有多一個fill變數，以及fill的set和get function，還有四個get function去計算左上角的x、左上角的y、寬度及高度，也有一個abstract function - draw。
MyRectangle.java extends MyBoundedShape，有完整的draw function，且可以依據fill的值，決定是否填滿圖案。
MyOval.java extends MyBoundedShape，有完整的draw function，且可以依據fill的值，決定是否填滿圖案。

DrawPanel.java
variable:
array shapes，初始值為100。
shapeCount計算有幾個圖案，初始值為0。
shapeType紀錄圖案的種類，初始值為0。
currentShape表示目前使用者所畫的圖案，初始值為null。
currentColor紀錄目前圖案的顏色，初始值為Color.BLACK。
filledShape紀錄圖案是否被填滿。
statusLabel要顯示目前滑鼠的所在座標。
method:
Override paintComponent，將shapes內的圖案都畫出來，且如果currentShape不是null，也將currentShape畫出來。
shapeType, currentColor, filledShape的set function。
clearLastShape利用把shapeCount減一，將shapes最後一個圖案刪除，並呼叫repaint，執行重畫。
clearDrawing利用把shapeCount設為零，將shapes清空，並呼叫repaint，執行重畫。
inner class，Override mousePressed, mouseReleased, mouseMoved, mouseDragged四個function。
mousePressed，當點擊滑鼠時，新增一個shapeType的圖案，並將滑鼠的座標訂為x1, y1, x2, y2。
mouseReleased，當滑鼠釋放時，把目前滑鼠的座標，訂為x2, y2，將shapeCount加一，把currentShape放到shapes內，然後currentShape設為null，並呼叫repaint，執行重畫。
mouseMoved，更新statusLabel。
mouseDragged，當滑鼠點擊並移動時，更新statusLabel，並把目前的滑鼠座標訂為x2, y2，讓使用者能看到畫圖的過程，並呼叫repaint，執行重畫。
constructor，包含一個JLabel變數。

DrawFrame.java:
undo button，呼叫clearLastShape，將最後一個圖案刪除。
clear button，呼叫clearDrawing，將畫面清空。
combo box colorComboBox，可經由下拉選單選擇預設的13個顏色。
combo box shapeComboBox，可經由下拉選單選擇預設的3個形狀。
checkbox filled，可經由勾選決定是否填滿圖案。

makefile:
利用make指令，compile上述檔案，即可執行TestDraw跳出視窗，畫出想要的圖案。
需在Java 1.6的版本之上執行。