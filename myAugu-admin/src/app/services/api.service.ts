import {Injectable} from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const httpOptions={
	headers:new HttpHeaders({'content-Type':'application/json'})
}

@Injectable({
	providedIn:'root'
})
export class ApiService{
	private serviceUrl="/api";
	constructor(private httpClient:HttpClient){
	}
	getEmployList():Observable<EmployListResp>{
		return this.httpClient.get<>(this.serviceUrl+"/employ/getAll");
	}
}