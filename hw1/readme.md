作者：電機111 乙班 王俊傑 E24072073

程式檔案名稱：hw1
(1)	需求描述:使用者可能會在輸入編號時輸入非系統所需的字串,針對這點做了辨識錯誤的功能,可以在輸入錯誤時提醒使用者再次輸入,且文字說明簡單易懂,使用者能夠輕易上手


(2)	程式流程:

(3)	功能/邏輯說明:


1.	辨識錯誤的功能:
While (輸入錯誤)
{系統要求再次輸入}
如輸入正確即可執行下一個步驟

2. 計算投票人數:
   int voters=0
   do
{單次投票程序
voters=voters+1
}while (使用者決定再次投票)
→每一人投票後voters就加一,可計算投票總人數

3.	計算得票數:
  if (年級<=4)
  {候選人票數=候選人票數+年級}
  else
  {候選人票數=候選人票數+0.5票}
  如此可計算不同年級的加權票數



(4)	使用說明:根據系統提示填入符合選票上的資訊,輸入完成後系統即會輸出候選人

