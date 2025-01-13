import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit {
  products: any[] | undefined;

  constructor(private http: HttpClient) {

  }

  ngOnInit(): void {
    this.http.get('http://localhost:8087/api/products').subscribe({
      next: (data: any) => {
        this.products = data;
        console.log(data);
      },
      error: (error: any) => {
        console.log(error);
      }
    })
  }

}
