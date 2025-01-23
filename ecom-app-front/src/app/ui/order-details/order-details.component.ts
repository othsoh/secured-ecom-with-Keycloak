import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';
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
  totalPrice = 0;
  shipping_charge = 100;

  status = ["PENDING", "CONFIRMED", "SHIPPED", "DELIVERED", "CANCELLED"];


  constructor(private http: HttpClient, private route: ActivatedRoute, private datePipe: DatePipe) {
  }

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


  calculateDiscountedPrice(productItem: any) {
    const discountedPrice = productItem.price - ((productItem.price * productItem.discount) / 100);
    return parseFloat(discountedPrice.toFixed(0));
  }

  calculateTotalPriceForOneProduct(productItem: any) {
    if (productItem.discount !== null) {
      return this.calculateDiscountedPrice(productItem.product) * productItem.quantity;
    } else {
      return productItem.product.price * productItem.quantity;
    }
  }

  formatPrice(price: number): string {
    return (price / 1000).toLocaleString('de-DE', {minimumFractionDigits: 3, maximumFractionDigits: 3});
  }

  calculateTotalPrice() {
    let totalPrice = 0;
    this.order.productItems.forEach((product: any) => {
      totalPrice += this.calculateTotalPriceForOneProduct(product);
    });
    this.totalPrice = totalPrice;
    return totalPrice;
  }

  calculateTaxFees() {
    return this.calculateTotalPrice() * 0.2;
  }

  calculateGrandTotalTTC() {
    return this.calculateTotalPrice() + this.calculateTaxFees() + this.shipping_charge;
  }
  getPreviousStatuses(currentStatus: string): string[] {
    const currentIndex = this.status.indexOf(currentStatus);
    if (currentIndex === -1) {
      return [];
    }
    return this.status.slice(0, currentIndex + 1);
  }

}
