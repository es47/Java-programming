12.17
�ھ�8.1, 9.1, 10.2���n�D�A�g�XMyShape.java, MyLine.java, MyBoundedShape.java, MyRectangle.java, MyOval.java�����ɮסC
MyShape.java��x1, y1, x2, y2��color�����ܼơA�H�ΨC���ܼƪ�set�Mget function�A�����constructor�A�٦��@��abstract function - draw�C
MyLine.java extends MyShape�A�����㪺draw function�C
MyBoundedShape.java extends MyShape�A�٦��h�@��fill�ܼơA�H��fill��set�Mget function�A�٦��|��get function�h�p�⥪�W����x�B���W����y�B�e�פΰ��סA�]���@��abstract function - draw�C
MyRectangle.java extends MyBoundedShape�A�����㪺draw function�A�B�i�H�̾�fill���ȡA�M�w�O�_�񺡹ϮסC
MyOval.java extends MyBoundedShape�A�����㪺draw function�A�B�i�H�̾�fill���ȡA�M�w�O�_�񺡹ϮסC

DrawPanel.java
variable:
array shapes�A��l�Ȭ�100�C
shapeCount�p�⦳�X�ӹϮסA��l�Ȭ�0�C
shapeType�����Ϯת������A��l�Ȭ�0�C
currentShape��ܥثe�ϥΪ̩ҵe���ϮסA��l�Ȭ�null�C
currentColor�����ثe�Ϯת��C��A��l�Ȭ�Color.BLACK�C
filledShape�����Ϯ׬O�_�Q�񺡡C
statusLabel�n��ܥثe�ƹ����Ҧb�y�СC
method:
Override paintComponent�A�Nshapes�����Ϯ׳��e�X�ӡA�B�p�GcurrentShape���Onull�A�]�NcurrentShape�e�X�ӡC
shapeType, currentColor, filledShape��set function�C
clearLastShape�Q�Χ�shapeCount��@�A�Nshapes�̫�@�ӹϮקR���A�éI�srepaint�A���歫�e�C
clearDrawing�Q�Χ�shapeCount�]���s�A�Nshapes�M�šA�éI�srepaint�A���歫�e�C
inner class�AOverride mousePressed, mouseReleased, mouseMoved, mouseDragged�|��function�C
mousePressed�A���I���ƹ��ɡA�s�W�@��shapeType���ϮסA�ñN�ƹ����y�Эq��x1, y1, x2, y2�C
mouseReleased�A��ƹ�����ɡA��ثe�ƹ����y�СA�q��x2, y2�A�NshapeCount�[�@�A��currentShape���shapes���A�M��currentShape�]��null�A�éI�srepaint�A���歫�e�C
mouseMoved�A��sstatusLabel�C
mouseDragged�A��ƹ��I���ò��ʮɡA��sstatusLabel�A�ç�ثe���ƹ��y�Эq��x2, y2�A���ϥΪ̯�ݨ�e�Ϫ��L�{�A�éI�srepaint�A���歫�e�C
constructor�A�]�t�@��JLabel�ܼơC

DrawFrame.java:
undo button�A�I�sclearLastShape�A�N�̫�@�ӹϮקR���C
clear button�A�I�sclearDrawing�A�N�e���M�šC
combo box colorComboBox�A�i�g�ѤU�Կ���ܹw�]��13���C��C
combo box shapeComboBox�A�i�g�ѤU�Կ���ܹw�]��3�ӧΪ��C
checkbox filled�A�i�g�ѤĿ�M�w�O�_�񺡹ϮסC

makefile:
�Q��make���O�Acompile�W�z�ɮסA�Y�i����TestDraw���X�����A�e�X�Q�n���ϮסC
�ݦbJava 1.6���������W����C