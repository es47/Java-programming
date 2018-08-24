10.17
根據課本程式範例寫出一個計算碳足跡的程式，並利用繼承。
CarbonFootprint.java為interface，只有getCarbonFootprint()。
Building.java , Car.java , Bicycle.java為CarbonFootprint.java的subclass，各自計算各自的碳足跡數量。
CarbonFootprintTest.java建立Building, Car, Bicycle三個物件，並呼叫CarbonFootprint.java的getCarbonFootprint()，輸出各個物件的碳足跡。

編譯說明:
使用make即可執行程式，執行後使用make clean即可清除.class檔。