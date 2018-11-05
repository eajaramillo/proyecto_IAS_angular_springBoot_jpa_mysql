export class Zona {
    cdzona: string;
    dsnombre_zona: string;
}

export class Pais {
    cdpais: string;
    dsnombre_pais: string;
    cdzona: string;
}

export class Ave {
    //id: number;
    cdave: string;
    dsnombre_comun: string;
    dsnombre_cientifico: string;
    //pais: Pais;
}

export class Busqueda {
    dsnombre_ave: string;
    cdzona: string;
}