import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.css'
})
export class OrdersComponent implements OnInit {

  Orders: any = [];

  constructor(public http: HttpClient, public router: Router) {
  }

  ngOnInit(): void {
    this.http.get('http://localhost:8081/api/orders').subscribe(
      {
        next: (data: any) => {
          this.Orders = data;
          console.log(data);
        },
        error: (error: any) => {
          console.log(error);
        }
      })
  }

  getStatusClass(status: string): string {
    switch (status) {
      case 'PENDING':
        return 'bg-amber-500/20 text-amber-900';
      case 'CONFIRMED':
        return 'bg-blue-500/20 text-blue-900';
      case 'SHIPPED':
        return 'bg-purple-500/20 text-purple-900';
      case 'CANCELLED':
        return 'bg-red-500/20 text-red-900';
      case 'DELIVERED':
        return 'bg-green-500/20 text-green-900';
      default:
        return '';
    }
  }

  viewOrderDetails(order: any) {
    this.router.navigateByUrl("/orders/" + order.id).then(r => {
      console.log(r);
    });
  }

}
