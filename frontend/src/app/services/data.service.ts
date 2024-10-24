import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {catchError, Observable, retry, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private apiUrl = "http://localhost:8080/api/users";

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrl)
      .pipe(
        retry(3),
        catchError(this.handleError)
      )
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = `An error occurred: ${error.error.message}`;
    } else {
      errorMessage = `Server returned code: ${error.status}, error message is: ${error.message}`;
    }
    console.error(errorMessage);
    return throwError(() => new Error(errorMessage));
  }
}
