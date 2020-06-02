angular.module('SoccerApp', []).controller('SoccerCtrl', function($http) {
	var ctrl = this;
	ctrl.newPlayer = {};
	ctrl.newTeam = {};

	ctrl.listPLayers = function() {
		var req = {
			method : 'GET',
			url : '/player',
			headers : {
				'Content-Type' : 'application/json'
			},
		}
		$http(req).then(function(result) {
			// console.log(result.data);
			ctrl.players = result.data
		}, function() {

		});
	};

	ctrl.addPlayer = function(player) {
		var req = {
			method : 'POST',
			url : '/player',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : player
		}
		$http(req).then(function() {
			ctrl.listPLayers();
			ctrl.newPlayer = {};
		}, function() {

		});
	};

	// ////////////////////
	ctrl.listTeams = function() {
		var req = {
			method : 'GET',
			url : '/team',
			headers : {
				'Content-Type' : 'application/json'
			},
		}
		$http(req).then(function(result) {
			// console.log(result.data);
			ctrl.teams = result.data
		}, function() {

		});
	};

	ctrl.addTeam = function(team) {
		var req = {
			method : 'POST',
			url : '/team',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : team
		}
		$http(req).then(function() {
			ctrl.listTeams();
			ctrl.newTeam = {};

		}, function() {

		});
	};

});