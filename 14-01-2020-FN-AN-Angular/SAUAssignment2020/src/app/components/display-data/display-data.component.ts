import { Component, OnInit } from '@angular/core';
import { BridgeService } from 'src/app/providers/bridge.service';

@Component({
  selector: 'app-display-data',
  templateUrl: './display-data.component.html',
  styleUrls: ['./display-data.component.css']
})
export class DisplayDataComponent implements OnInit {

  data = this.bridgeService.localData;
  constructor(public bridgeService : BridgeService) {

   }

   deleteRecord(index){
     this.bridgeService.delete(index);
   }

  ngOnInit() {
  }

}
