import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CurdHttpService } from '../curd-http.service';

import { User } from '../user';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  id: number
  user: User
  constructor(private route:ActivatedRoute, private crudService:CurdHttpService,private router:Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.user = new User();
    this.crudService.getUserById(this.id).subscribe( db => {
      this.user = db;
    });
  }
  goBack(){
    this.router.navigate(['admin']);
  }

  deleteUser(id: number){
    this.crudService.deleteUser(id).subscribe( data => {
      alert("User data deleted");
      this.router.navigate(['admin']);
    });
  }
    updateUser(id: number){
      this.router.navigate(['edit', id]);
    }
  
}
