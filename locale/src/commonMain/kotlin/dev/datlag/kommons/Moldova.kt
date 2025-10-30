package dev.datlag.kommons


data object Moldova : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MD")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MDA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(498)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(373)
}