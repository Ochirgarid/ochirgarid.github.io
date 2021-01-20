"use strict";

let accountInfoList = [];

let Account = (() => {
    function createAccount() {
        return {
            privateAccountName: document.getElementById("accountName").value,
            privateAccountBalance: document.getElementById("deposit").value,
            getAccountBalance(){
                return this.privateAccountBalance;
            },
            getAccountName(){
                return this.privateAccountName;
            }
        };
    }
    return {createAccount};
})();


function addAccountHandler() {
    let acc = Account.createAccount();
    accountInfoList.push(acc);
    // "Account name: saving   Balance: 100"
    let allAccountInfo = "";
    for(let i = 0; i < accountInfoList.length; i++) {
        allAccountInfo += "Account name: " 
            + accountInfoList[i].getAccountName()
            + "  "
            + "Balance: "
            + accountInfoList[i].getAccountBalance()
            + "\n";
    }
    console.log(allAccountInfo)
    document.getElementById("accountInfo").value = allAccountInfo;
}