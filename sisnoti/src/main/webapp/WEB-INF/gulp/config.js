'use strict';

module.exports = {

  'browserPort'  : 3002,
  'UIPort'       : 3001,
  'serverPort'   : 3000,

  'watch': {
    'scripts' : ['resources/front/js/modules/*.js', 'resources/front/js/moules/**/*.js'],
    'styles' : ['resources/front/css/stylus/*.styl', 'resources/front/css/stylus/**/**/*.styl', 'resources/front/css/dist/*.css'],
    'image' : ['resources/front/image/**/**/*'],
    'views' : ['resources/back/modules/**/views/*.jade', 'resources/back/modules/**/views/partials/*.jade']
  },

  // 'nodemon': {
  //   'script': 'back/bin/www',
  //   'ext': 'js',
  //   'env': 'development',
  //   'watch': 'back/'
  // },

  'styles': {
    'src' : 'resources/front/css/stylus/*.styl',
    'dest': 'resources/front/build/css'
  },

  'css': {
    'src' : 'resources/front/css/dist/*.css',
    'dest': 'resources/front/build/css'
  },

  'scripts': {
    'src' : ['resources/front/js/**/*.js', 'resources/front/js/**/**/*.js'],
    'dest': 'resources/front/build/js'
  },

  'images': {
    'src' : ['resources/front/image/*', 'resources/front/image/**/**/*'],
    'dest': 'resources/front/build/images'
  },

  'fonts': {
    'src' : 'resources/front/css/fonts/*',
    'dest': 'resources/front/build/css/fonts'
  },

  'gzip': {
    'src': 'resources/front/build/**/*.{html,xml,json,css,js,js.map}',
    'dest': 'resources/front/build/',
    'options': {}
  },

  'dist': {
    'root'  : 'build'
  },

  'browserify': {
    'entries'   : ['front/js/app.js'],
    'bundleName': 'app.js',
    'sourcemap' : true
  },

  'test': {
    'source': [
      'resources/front/js/test/modules/**/*Spec.js',
      'resources/back/test/modules/**/*Spec.js'
    ],
    'jade': {
      'source': 'resources/back/modules/**/views/*.jade',
      'dest': 'resources/front/js/test/templates'
    }
  }

};
