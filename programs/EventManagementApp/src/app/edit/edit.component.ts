import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CurdHttpService } from '../curd-http.service';
import { User } from '../user';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  registerForm: FormGroup;
  submitted:boolean=false;
  id:number;
  user: User = new User();

  constructor(private crudService:CurdHttpService,private router:Router,
              private route:ActivatedRoute,private builder:FormBuilder) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.crudService.getUserById(this.id).subscribe(data => {
      this.user = data;
    }, error => console.log(error));

    this.registerForm= this.builder.group(
      {
        firstName:["",Validators.required],
        lastName:["",Validators.required],
        emailId:["",[Validators.required,Validators.email]]
      }
    );
  }

  onSubmit(){
    this.submitted=true;
    if(this.registerForm.invalid)
      return;
    else{
      this.crudService.updateUser(this.id, this.user).subscribe( data =>{
        this.goToEmployeeList();
      }
      , error => console.log(error));
    } 
  }
  get f(){
    return this.registerForm.controls;
  }

  goToEmployeeList(){
    this.router.navigate(['/admin']);
  }

}
