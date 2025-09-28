# Project Proposal

## Overview

SonarQube is a developer tool to perform static analysis on source code repositories.
 Its primary goals are to improve code quality and security through the enforcement of best
 practices. It automates the detection of linting and formatting issues,
 monitors code coverage of tests, catches common security vulnerabilities, and more.
 Through this tool, developers are able to more strictly enforce standards and practices.
 The end result is software that is more secure, performant, and—most importantly—maintainable.

SonarQube is highly flexible. The application is offered on the cloud or can be hosted on-prem.
 It can be included in continuous integration pipelines to perform checks frequently, and is
 highly configurable to fit a developer's need for many projects.
 While written in Java, SonarQube supports a variety of languages and paradigms–including
 dynamically-typed languages (Python, JavaScript), low-level programming languages (C, Rust), and
 other widely-used programming tools (Kubernetes, Docker).

One of the major appeals of SonarQube is its ability to generate actionable tasks to improve
 software based on quality metrics, such as reliability, understandability, and maintainability.

## Key Quality Metrics

### Compatibility

Given that SonarQube is able to support so many project languages and
configurations, compatibility must be one of the most important software
metrics. This makes sense, given their platform and business model; the
more projects they can supports will increase their user base. This is
particularly true for multi-language projects (e.g., a JS frontend and
Python backend). Providing a single tool to perform checks on the whole
repo instead of requiring users to manage multiple dependencies for the
same task streamlines the software quality analysis process.

### Performance Efficiency

Initial analysis of the repository revealed that many components are
able to be multi-threaded. Since the tool can be used in CI pipelines,
it would track the scanner needs to be able to run on (at least) GitHub
runners or in some way interact with an external API. Users would want a
responsive API to verify the quality of their code quickly.

### Interaction Capability

One of SonarQube's major selling points is that repository owners are able
to enforce their own chosen standards for any repository. SonarQube gives
its users the agency to decide on their own needs for a project instead of
a set of prescribed practices. If, for example, a TypeScript project
disabled the rule for `no-explicit-any`, SonarQube would not flag these
"errors" even if standard practice dictates otherwise.
