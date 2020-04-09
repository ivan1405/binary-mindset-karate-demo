function fn() {

    var environment = karate.properties['env'];
    if(!environment) {
        environment = 'localhost'
    }

    var port = karate.properties['port'];
    if(!port) {
        port = '8082'
    }

    var host = 'localhost';
    if('dev' === environment) {
        host = '192.168.1.203'
    }

    karate.log('using ' + environment + ' environment')

    return {
        apiBasePath: 'http://' + host + ':' + port + '/tasklist-management/api'
    };
}