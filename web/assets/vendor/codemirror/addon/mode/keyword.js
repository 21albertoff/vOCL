// copyright (c) by erosman https://github.com/erosman/CodeMirror-plus
// Distributed under an Mozilla Public License 2.0: https://www.mozilla.org/en-US/MPL/2.0/

(function(mod) {
  if (typeof exports == "object" && typeof module == "object") // CommonJS
    mod(require("../../lib/codemirror"));
  else if (typeof define == "function" && define.amd) // AMD
    define(["../../lib/codemirror"], mod);
  else // Plain browser env
    mod(CodeMirror);
})(function(CodeMirror) {
  CodeMirror.defineOption("keyword", {}, function(cm, val, prev) {
    if (prev == CodeMirror.Init) prev = false;
    if (prev && !val)
      cm.removeOverlay("keyword");
    else if (!prev && val)
      cm.addOverlay({
        token: function(stream) {
          for (var key in cm.options.keyword) {
            if (stream.match(key, true)) {return cm.options.keyword[key];}
          }
          stream.next();
        },
        name: "keyword"
      });
  });

  const editor = CodeMirror(document.body, {
    lineNumbers: true,
    mode:  "javascript",
    keyword: {
      "word1": "style1",
      "word2": "style1",
      "word3": "style1",
      "word4": "style2"
    }
  });
  
});