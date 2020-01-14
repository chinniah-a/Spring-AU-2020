import { Component, OnInit } from '@angular/core';
import {FormControl,FormGroup, Validators} from '@angular/forms';
import { BridgeService } from 'src/app/providers/bridge.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(public bridgeService : BridgeService) { }
  formGrp = new FormGroup({
    name : new FormControl('',Validators.required),
    surname : new FormControl('',Validators.required),
    // age : new FormControl('',Validators.required),
    email : new FormControl('',Validators.required),
    city : new FormControl('',Validators.required),
    // pincode : new FormControl('',Validators.required),
    country : new FormControl('',Validators.required),


  });
  ngOnInit() {
  }


  processForm(){
    console.log(this.formGrp);
    console.log(this.formGrp.value);
    this.bridgeService.acceptInputFromForm(this.formGrp.value);
    this.resetForm();
  }


  resetForm(){
    this.formGrp.patchValue({ name: '',
    surname : '', 
    // age : 19, 
    email : '', 
    city : '', 
    // pincode : '',
    country : ''});
  }
  updateForm(){
    this.formGrp.patchValue({ name: 'Rohit',
    surname : 'Gonsalves', 
    // age : 19, 
    email : 'gonsalvesrohit920@gmail.com', 
    city : 'Mumbai', 
    // pincode : '401202',
    country : 'India'});
  }

}
