# 學生會長投票系統
作者：電機111 乙班 王俊傑 E24072073

程式檔案名稱：hw1
## 需求描述:
使用者可能會在輸入編號時輸入非系統所需的字串,針對這點做了辨識錯誤的功能,可以在輸入錯誤時提醒使用者再次輸入,

且文字說明簡單易懂,使用者能夠輕易上手

## 程式流程:

![image](https://user-images.githubusercontent.com/80030514/126647792-e7012a60-aa84-475c-aa8a-5f8da121a316.png)


## 功能/邏輯說明:


>1.辨識錯誤的功能:

&emsp;&emsp;While (輸入錯誤)

&emsp;&emsp;&emsp;{系統要求再次輸入}

如輸入正確即可執行下一個步驟

>2.計算投票人數:

&emsp;&emsp;   int voters=0
   
&emsp;&emsp;   do
   
&emsp;&emsp;{

&emsp;&emsp;&emsp;&emsp;單次投票程序

&emsp;&emsp;&emsp;&emsp;voters=voters+1

&emsp;&emsp;}while (使用者決定再次投票)

&emsp;&emsp;→每一人投票後voters就加一,可計算投票總人數

>3.計算得票數:

&emsp;&emsp;if (年級<=4)
  
&emsp;&emsp;&emsp;{候選人票數=候選人票數+年級}
  
&emsp;&emsp;else
  
&emsp;&emsp;&emsp;{候選人票數=候選人票數+0.5票}
  
&emsp;&emsp;如此可計算不同年級的加權票數



## 使用說明:

根據系統提示填入符合選票上的資訊,輸入完成後系統即會輸出候選人


