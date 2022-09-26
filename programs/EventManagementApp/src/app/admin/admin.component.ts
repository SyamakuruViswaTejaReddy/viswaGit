import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CurdHttpService } from '../curd-http.service';



@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  title = 'EventManagementApp';

  todoList:any = [];


  constructor(private crudHttpService: CurdHttpService,private router:Router){}

  
  ngOnInit(): void {
    this.listTodos();
  }

  listTodos(){
    this.crudHttpService.list().subscribe((response)=>{
      this.todoList = response;
    },(error=>{

    }));
  }
  
  add(){
    this.router.navigateByUrl("/user");
  }

  show(id: number){
    this.router.navigate(['details', id]);
  }


  deleteTodo(id: any){
    this.crudHttpService.delete(id).subscribe((response)=>{
      this.listTodos();
    },(error=>{
    }));
  }


}
