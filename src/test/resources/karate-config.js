function fn() {

    var environment = karate.properties['env'];
    if(!environment) {
        environment = 'localhost'
    }

    var port = karate.properties['port'];
    if(!port) {
        port = '8082'
    }

    return {
        apiBasePath: 'http://' + environment + ':' + port + '/tasklist-management/api'
    };
}