//Monta JsonEndereco
function getJsonEndereco(idEndereco, dsRua, dsNumero, dsComplemento, nmBairro, nrCep, nrLatitude, nrLongitude){
	(nrCep != "") ? nrCep = parseInt(nrCep) : nrCep = parseInt(0);
	(nrLatitude != "") ? nrLatitude = parseFloat(nrLatitude) : nrLatitude = parseFloat(0);
    (nrLongitude != "") ? nrLongitude = parseFloat(nrLongitude) : nrLongitude = parseFloat(0);

	var jsonEndereco = {idEndereco: parseInt(idEndereco), 
				   	    dsRua: dsRua,
		        	    dsNumero: dsNumero,
		          	    dsComplemento: dsComplemento,
		           	    nmBairro: nmBairro,
		                nrCep: nrCep,
		                nrLatitude: nrLatitude,
		                nrLongitude: nrLongitude
        	           };
	return jsonEndereco;
}