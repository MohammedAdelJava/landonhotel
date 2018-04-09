import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {Headers, Http, RequestOptions, Response} from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {


  constructor(private http: Http) {

        }

  private baseUrl = 'http://localhost:8080' ;
  public submitted: boolean;
  roomsearch: FormGroup;
  rooms: Room[];
  currentCheckInValue: string ;
  currentCheckOutValue: string ;
  request: ReserveRoomRequest;



    ngOnInit() {
        this.roomsearch = new FormGroup({
            checkin: new FormControl(''),
            checkout: new FormControl('')
        });

        const roomsearchValueChanges$ = this.roomsearch.valueChanges;

        roomsearchValueChanges$.subscribe( valChange => {
          this.currentCheckInValue = valChange.checkin;
          this.currentCheckOutValue = valChange.checkout;
          }
        );


    }

    onSubmit({value, valid }: {value: Roomsearch, valid: boolean}) {
      this.getAll().subscribe(
        rooms => this.rooms = rooms ,
        err => {
          console.log(err);
        }
      );

      console.log(this.rooms);
    }

    reserveRoom(value: string) {
      console.log(value);
      this.request =  new ReserveRoomRequest(value, this.currentCheckInValue, this.currentCheckOutValue);
      console.log(this.request);
      this.createReservation(this.request);
    }

    createReservation(body: ReserveRoomRequest ) {
      const bodyString = JSON.stringify(body);
      console.log(bodyString);
      const headers = new Headers({'Content-Type': 'application/json'});
      const option = new RequestOptions({headers: headers});
      console.log(this.http.post(this.baseUrl + '/room/reservation/v1', body , option));
      this.http.post(this.baseUrl + '/room/reservation/v1', body , option)
        .subscribe(res =>  console.log(res));
    }

    getAll(): Observable<Room[]> {

       return this.http
         .get(this.baseUrl + '/room/reservation/v1?checkin=' + this.currentCheckInValue + '&checkout=' + this.currentCheckOutValue + '')
         .map(this.mapRoom);
    }

    mapRoom(response: Response): Room[] {

        return response.json().content;

    }

}

export interface Roomsearch {
  checkin: string;
  checkout: string;
}

export interface Room {
  id: string;
  roomNumber: string;
  price: string;
  links: string;
}

export class ReserveRoomRequest {
  roomId: string;
  checkin: string;
  checkout: string;

  constructor (roomId: string, checkin: string, checkout: string) {
    this.roomId = roomId;
    this.checkin = checkin;
    this.checkout = checkout;
  }


}






