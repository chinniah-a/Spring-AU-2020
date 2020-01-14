import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BridgeService {

  constructor() { }

 localData = this.retrieve();

 private store(data){
   var local = this.retrieve();
   
     local.push(data);
    localStorage.setItem('data',JSON.stringify(local));

    return [...local];

   
  }

 private retrieve(){
    let data = JSON.parse(localStorage.getItem('data'));
    if(data)
    return data;
    return [];
  }


  setLocalData(data){
    this.localData = data;
  }

acceptInputFromForm(data){
  let curdata =  this.store(data);
  this.setLocalData(curdata);
}

delete(index){
  this.localData.splice(index,1);
  this.storeAll([...this.localData]);
}

private storeAll(local){
  localStorage.setItem('data',JSON.stringify(local));
}

}
