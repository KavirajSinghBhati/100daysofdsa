const { src, dest, watch, series } = require("gulp");
const sass = require("gulp-sass")(require("sass"));
const postcss = require("gulp-postcss");
const cssnano = require("cssnano");
const terser = require("gulp-terser");
const browsersync = require("browser-sync").create();

// Sass tasks

const scsstask = () =>
  src("app/scss/style.scss", { sourcemaps: true })
    .pipe(sass())
    .pipe(postcss([cssnano()]))
    .pipe(dest("dist", { sourcemaps: "." }));

// JavaScript task

const jstask = () =>
  src("app/js/script.js", { sourcemaps: true })
    .pipe(terser())
    .pipe(dest("dist", { sourcemaps: "." }));

// Browsersync task

const browsersyncServe = (cb) => {
  browsersync.init({
    server: {
      baseDir: ".",
    },
  });
  cb();
};

const browsersyncReload = (cb) => {
  browsersync.reload();
  cb();
};

// watch task

const watchtask = () => {
  watch("*.html", browsersyncReload);
  watch(
    ["app/scss/**/*.scss", "app/js/**/*.js"],
    series(scsstask, jstask, browsersyncReload)
  );
};

// Default gulp tasks

exports.default = series(scsstask, jstask, browsersyncServe, watchtask);
