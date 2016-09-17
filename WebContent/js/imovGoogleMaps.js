var mapa;
var marcador;
var marcadores = [];
var infoWindow;

function inicializarGoogleMaps(nrLatitude, nrLongitude, dsMarcador, dsEndereco, nrCep, flClick){
    google.maps.event.addDomListener(window, 'load', carregarParametrosGoogleMaps(nrLatitude, nrLongitude, dsMarcador, dsEndereco, nrCep));
    
    if (nrLatitude != 0 && nrLongitude != 0){
    	criarMarcador(nrLatitude, nrLongitude, dsMarcador, dsEndereco, nrCep);
    }
    
    if (flClick){
    	eventoGetCoordenadasClickMaps();
    }
}

function carregarParametrosGoogleMaps(nrLatitude, nrLongitude, dsMarcador){
	var latlng;
	if (nrLatitude != 0 && nrLongitude != 0){
		latlng = new google.maps.LatLng(nrLatitude, nrLongitude);
	}
	else{
		latlng = new google.maps.LatLng(-15.800429, -47.864891);
	}

    var options = {
        zoom: (nrLatitude != 0 && nrLongitude != 0)?18:3,
        center: latlng,
        mapTypeId: 'roadmap'
    };

    mapa = new google.maps.Map(document.getElementById('mapa'), options);
    infoWindow = new google.maps.InfoWindow();
    eventoFechaAlertaMarcadorClickMaps();
}

function criarMarcador(nrLatitude, nrLongitude, dsMarcador, dsEndereco, nrCep){
	marcador = new google.maps.Marker({
	    position: new google.maps.LatLng(nrLatitude, nrLongitude),
	    title: dsMarcador,
	    draggable: true,
	    map: mapa
	});
	var idMarcador = marcadores.push(marcador) - 1;
	eventoAlertaMarcadorClickMaps(marcadores[idMarcador], dsMarcador, dsEndereco, nrCep);
	return idMarcador
}

function limparMarcadores(){
	if (marcadores) {
		for (var i = 0; i < marcadores.length; i++){
			marcadores[i].setMap(null);
		}
		marcadores=[];
   }
}

function eventoAlertaMarcadorClickMaps(marcador, dsMarcador, dsEndereco, nrCep){
	google.maps.event.addListener(marcador, 'click', function() {
	      
	      // Variável que define a estrutura do HTML a inserir na Info Window.
	      var iwContent = '<div id="iw_container">' +
	      '<div class="iw_title">' + dsMarcador + '</div>' +
	      '<div class="iw_content">' + dsEndereco + '<br />' +
	      nrCep + '</div></div>';
	      
	      // O conteúdo da variável iwContent é inserido na Info Window.
	      infoWindow.setContent(iwContent);

	      // A Info Window é aberta com um click no marcador.
	      infoWindow.open(mapa, marcador);
	   });
}

function eventoFechaAlertaMarcadorClickMaps(){
	google.maps.event.addListener(mapa, 'click', function() {
	      infoWindow.close();
	});
}

function eventoGetCoordenadasClickMaps(){
	google.maps.event.addListener(mapa, "click", function(event) {
		var nrLatitude = event.latLng.lat().toFixed(6);
		var nrLongitude = event.latLng.lng().toFixed(6);
		limparMarcadores();
		criarMarcador(nrLatitude, nrLongitude, "", "", "");
		atualizaCoordenadas(nrLatitude, nrLongitude);
		eventoDetectaArrastoMarcador();
	});
}

function eventoDetectaArrastoMarcador(){
	google.maps.event.addListener(marcador, 'dragend', function() {
		marcador.position = marcador.getPosition();
	    var nrLatitude = marcador.position.lat().toFixed(6);
	    var nrLongitude = marcador.position.lng().toFixed(6);
	    atualizaCoordenadas(nrLatitude, nrLongitude);
	});
}

function carregarMarcadores(jsonMarcadores){
	var bounds = new google.maps.LatLngBounds();
	var marcado;
	var nrLatitude;
	var nrLongitude;
	var descricao;
	var endereco;
	var cep;
	for (var i = 0; i < jsonMarcadores.length; i++) {
		marcador = jsonMarcadores[i];
	   	nrLatitude = marcador.nrLatitude;
		nrLongitude = marcador.nrLongitude;
		dsMarcador = marcador.dsMarcador;
		dsEndereco = marcador.dsEndereco;
		nrCep = marcador.nrCep;
		criarMarcador(nrLatitude, nrLongitude, dsMarcador, dsEndereco, nrCep);
		bounds.extend(new google.maps.LatLng(nrLatitude, nrLongitude));
	}
	mapa.fitBounds(bounds);
}

function atualizaCoordenadas(lat, lng) {
	$("#nrLatitude").val(lat);
	$("#nrLongitude").val(lng);
}


