import { Injectable } from '@angular/core';

import { retry, catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { Alunos } from '../Models/Alunos';

export type EntityResponseType = HttpResponse<Alunos>;
export type EntityArrayResponseType = HttpResponse<Alunos[]>;

@Injectable({ providedIn: 'root' })
export class AlunosService {

    serverUrl = "http://localhost:8080";

    constructor(
        protected http: HttpClient
    ) {}

    create(alunos: Alunos): Observable<EntityResponseType> {
        return this.http.post<Alunos>(`${this.serverUrl}/alunos`, alunos, { observe: 'response' });
    }

    update(alunos: Alunos): Observable<EntityResponseType> {
        return this.http.put<Alunos>(`${this.serverUrl}/alunos`, alunos, { observe: 'response' });
    }

    getAll(orderBy: string, average: boolean): Observable<EntityArrayResponseType> {
        const params = new HttpParams()
            .set('orderby', orderBy)
            .set('average', average);
        return this.http.get<Alunos[]>(`${this.serverUrl}/alunos`, { observe: 'response', params });
    }

    query(string: String): Observable<EntityArrayResponseType> {
        let params = new HttpParams().set('query', string.toString());
        return this.http.get<Alunos[]>(`${this.serverUrl}/alunos`, { params: params, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<{}>> {
        return this.http.delete(`${this.serverUrl}/alunos/${id}`, { observe: 'response' });
    }
}