import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css'],
  providers: [DatePipe]

})
export class OrderDetailsComponent implements OnInit {

  order: any = {};
  orderId!: string;

  constructor(private http: HttpClient, private route: ActivatedRoute, private datePipe: DatePipe) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.orderId = params.get('orderId')!;
      this.fetchOrderDetails();
    });
  }

  fetchOrderDetails(): void {
    this.http.get('http://localhost:8081/api/orders/' + this.orderId).subscribe({
      next: (data: any) => {
        this.order = data;
        console.log(data);
      },
      error: (error: any) => {
        console.error('Error fetching order:', error);
      }
    });
  }
  formatDate(date: string): string {
    return this.datePipe.transform(date, 'MMMM d, y')!;
  }
}
